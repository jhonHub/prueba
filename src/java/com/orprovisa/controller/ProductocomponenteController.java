package com.orprovisa.controller;

import com.orprovisa.model.Productocomponente;
import com.orprovisa.controller.util.JsfUtil;
import com.orprovisa.controller.util.PaginationHelper;
import com.orprovisa.ejb.ProductocomponenteFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("productocomponenteController")
@SessionScoped
public class ProductocomponenteController implements Serializable {

    private Productocomponente current;
    private DataModel items = null;
    @EJB
    private com.orprovisa.ejb.ProductocomponenteFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProductocomponenteController() {
    }

    public Productocomponente getSelected() {
        if (current == null) {
            current = new Productocomponente();
            current.setProductocomponentePK(new com.orprovisa.model.ProductocomponentePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProductocomponenteFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Productocomponente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Productocomponente();
        current.setProductocomponentePK(new com.orprovisa.model.ProductocomponentePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getProductocomponentePK().setIdComponente(current.getComponente().getIdComponente());
            current.getProductocomponentePK().setIdProducto(current.getProducto().getIdProducto());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductocomponenteCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Productocomponente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getProductocomponentePK().setIdComponente(current.getComponente().getIdComponente());
            current.getProductocomponentePK().setIdProducto(current.getProducto().getIdProducto());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductocomponenteUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Productocomponente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductocomponenteDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Productocomponente getProductocomponente(com.orprovisa.model.ProductocomponentePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Productocomponente.class)
    public static class ProductocomponenteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductocomponenteController controller = (ProductocomponenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productocomponenteController");
            return controller.getProductocomponente(getKey(value));
        }

        com.orprovisa.model.ProductocomponentePK getKey(String value) {
            com.orprovisa.model.ProductocomponentePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.orprovisa.model.ProductocomponentePK();
            key.setIdProducto(Integer.parseInt(values[0]));
            key.setIdComponente(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.orprovisa.model.ProductocomponentePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdProducto());
            sb.append(SEPARATOR);
            sb.append(value.getIdComponente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Productocomponente) {
                Productocomponente o = (Productocomponente) object;
                return getStringKey(o.getProductocomponentePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Productocomponente.class.getName());
            }
        }

    }

}
