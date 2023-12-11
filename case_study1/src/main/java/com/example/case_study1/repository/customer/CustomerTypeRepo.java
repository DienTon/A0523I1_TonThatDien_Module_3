package com.example.case_study1.repository.customer;

import com.example.case_study1.model.customer.CustomerType;
import com.example.case_study1.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo implements ICustomerTypeRepo {
    private static final String FIND_ALL ="select * from loai_khach;";
    @Override
    public List<CustomerType> find_all() {
        List<CustomerType> result = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idCustomerType = rs.getInt("ma_loai_khach");
                String idCustomerTypeName = rs.getString("ten_loai_khach");
                result.add(new CustomerType(idCustomerType, idCustomerTypeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
