package com.example.case_study1.repository.dich_vu;

import com.example.case_study1.model.DichVu;

import java.sql.SQLException;
import java.util.List;

public class DichVuRepo implements IDichVuRepo{
    @Override
    public List<DichVu> showListDichVu() {
        return null;
    }

    @Override
    public void addDichVu(DichVu dichVu) {

    }

    @Override
    public void deleteDichVu(int id) throws SQLException {

    }

    @Override
    public void updateDv(DichVu dichVu) throws SQLException {

    }

    @Override
    public List<DichVu> selectByName(String name) {
        return null;
    }

    @Override
    public DichVu selectById(int id) {
        return null;
    }
}
