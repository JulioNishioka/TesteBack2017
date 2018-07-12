package br.com.TestBack2017.modelo;

import java.math.BigDecimal;

/**
 *
 * @author Casa
 */
public class Customer {
    private Long id_customer;
    private String cpf_cnpj;
    private String nm_customer;
    private String is_active;
    private BigDecimal vl_total;

    /**
     * @return the id_custormer
     */
    public Long getId_customer() {
        return id_customer;
    }

    /**
     * @param id_custormer the id_custormer to set
     */
    public void setId_customer(Long id_custormer) {
        this.id_customer = id_custormer;
    }

    /**
     * @return the cpf_cnpj
     */
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    /**
     * @param cpf_cnpj the cpf_cnpj to set
     */
    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    /**
     * @return the nm_customer
     */
    public String getNm_customer() {
        return nm_customer;
    }

    /**
     * @param nm_customer the nm_customer to set
     */
    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    /**
     * @return the is_active
     */
    public String getIs_active() {
        return is_active;
    }

    /**
     * @param is_active the is_active to set
     */
    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    /**
     * @return the vl_total
     */
    public BigDecimal getVl_total() {
        return vl_total;
    }

    /**
     * @param vl_total the vl_total to set
     */
    public void setVl_total(BigDecimal vl_total) {
        this.vl_total = vl_total;
    }
    
}


