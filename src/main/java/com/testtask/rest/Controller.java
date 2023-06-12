package com.testtask.rest;

import com.testtask.dao.CompanyDao;
import com.testtask.model.Company;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import javax.inject.Inject;
import java.util.List;

public class Controller extends SelectorComposer<Component> {
    @Inject
    CompanyDao companyDao;


    @Wire
    private Listbox companiesListBox;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        refreshCompaniesList();
    }

    private void refreshCompaniesList() {
        List<Company> companyList = companyDao.selectAllCompanies();
        companiesListBox.setModel(new ListModelList<>(companyList));
    }

}
