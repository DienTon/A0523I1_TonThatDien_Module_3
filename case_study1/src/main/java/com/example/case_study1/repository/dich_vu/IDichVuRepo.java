package com.example.case_study1.repository.dich_vu;

import com.example.case_study1.model.DichVu;

import java.sql.SQLException;
import java.util.List;

public interface IDichVuRepo {
    List<DichVu> showListDichVu();
    void addDichVu(DichVu dichVu);
    public void deleteDichVu(int id) throws SQLException;

    public void updateDv(DichVu dichVu) throws SQLException;
    public List<DichVu> selectByName(String name);
    public DichVu selectById(int id);
}
