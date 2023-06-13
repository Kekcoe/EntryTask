package com.testtask.rest;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import com.testtask.service.CompanyDaoService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

public class Controller extends SelectorComposer<Component> {

    Logger log = Logger.getLogger(Controller.class.getName());

    private final CompanyDao companyDao = new CompanyDaoService() ;


    @Wire
    private Listbox companiesListBox;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        if (companyDao != null && companiesListBox != null) {
            refreshCompaniesList();
            log.info("***doAfterCompose****");
        } else {
            log.warning("***companyDao or companiesListBox is null****");
        }
    }

    private void refreshCompaniesList() {
        log.info("****refreshCompaniesList****");
        List<Company> companyList = companyDao.selectAllCompanies();
        if (companyList != null && companiesListBox != null) {
            companiesListBox.setModel(new ListModelList<>(companyList));
        } else {
            log.warning("***companyList or companiesListBox is null****");
        }
    }

}
