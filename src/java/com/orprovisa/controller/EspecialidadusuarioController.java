package com.orprovisa.controller;

import com.orprovisa.model.Especialidadusuario;
import com.orprovisa.controller.util.JsfUtil;
import com.orprovisa.controller.util.PaginationHelper;
import com.orprovisa.ejb.EspecialidadusuarioFacade;

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

@Named("especialidadusuarioController")
@SessionScoped
public class EspecialidadusuarioController implements Serializable {

    private Especialidadusuario current;
    private DataModel items = null;
    @EJB
    private com.orprovisa.ejb.EspecialidadusuarioFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EspecialidadusuarioController() {
    }

    public Especialidadusuario getSelected() {
        if (current == null) {
            current = new Especialidadusuario();
            current.setEspecialidadusuarioPK(new com.orprovisa.model.EspecialidadusuarioPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private EspecialidadusuarioFacade getFacade() {
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
        current = (Especialidadusuario) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Especialidadusuario();
        current.setEspecialidadusuarioPK(new com.orprovisa.model.EspecialidadusuarioPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getEspecialidadusuarioPK().setIdusuario(current.getUsuario().getIdUsuario());
            current.getEspecialidadusuarioPK().setIdEspecialidad(current.getEspecialidad().getIdEspecialidad());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EspecialidadusuarioCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Especialidadusuario) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getEspecialidadusuarioPK().setIdusuario(current.getUsuario().getIdUsuario());
            current.getEspecialidadusuarioPK().setIdEspecialidad(current.getEspecialidad().getIdEspecialidad());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EspecialidadusuarioUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Especialidadusuario) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EspecialidadusuarioDeleted"));
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

    public Especialidadusuario getEspecialidadusuario(com.orprovisa.model.EspecialidadusuarioPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Especialidadusuario.class)
    public static class EspecialidadusuarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EspecialidadusuarioController controller = (EspecialidadusuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "especialidadusuarioController");
            return controller.getEspecialidadusuario(getKey(value));
        }

        com.orprovisa.model.EspecialidadusuarioPK getKey(String value) {
            com.orprovisa.model.EspecialidadusuarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.orprovisa.model.EspecialidadusuarioPK();
            key.setIdEspecialidad(Integer.parseInt(values[0]));
            key.setIdusuario(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.orprovisa.model.EspecialidadusuarioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEspecialidad());
            sb.append(SEPARATOR);
            sb.append(value.getIdusuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Especialidadusuario) {
                Especialidadusuario o = (Especialidadusuario) object;
                return getStringKey(o.getEspecialidadusuarioPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Especialidadusuario.class.getName());
            }
        }

    }

}
