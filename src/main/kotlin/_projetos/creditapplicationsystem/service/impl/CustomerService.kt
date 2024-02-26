package _projetos.creditapplicationsystem.service.impl

import _projetos.creditapplicationsystem.entity.Customer
import _projetos.creditapplicationsystem.exception.BusinessException
import _projetos.creditapplicationsystem.repository.CustomerRepository
import _projetos.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}