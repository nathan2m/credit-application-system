package _projetos.creditapplicationsystem.dto

import _projetos.creditapplicationsystem.entity.Credit
import _projetos.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Input cannot be null")
    val creditValue: BigDecimal,

    @field:Future
    val dayFirstOfInstallment: LocalDate,

    @field:Min(value = 1) @field:Max(value = 48)
    val numberOfInstallments: Int,

    @field:NotNull(message = "Input cannot be null")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
