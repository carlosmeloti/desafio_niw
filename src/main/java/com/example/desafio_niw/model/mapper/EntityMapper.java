package com.example.desafio_niw.model.mapper;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.model.CustomerDTO;
import com.example.desafio_niw.model.OrderDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    Order OrderDTOtoEntity(OrderDTO dto);
    OrderDTO entityToOrderDTO(Order entity);
    CustomerDTO entityToCustomerDTO(Customer entity);
    Customer CustomerDTOToEntity(CustomerDTO dto);
    List<CustomerDTO> entityToCustomerDTOList(List<Customer> entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDTO(CustomerDTO dto, @MappingTarget Customer entity);
}
