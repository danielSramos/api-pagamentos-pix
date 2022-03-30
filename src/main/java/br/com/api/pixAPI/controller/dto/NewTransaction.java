package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.Transaction;

public class NewTransaction {

    private Long transactionId;
    private Long receiverPixId;
    private Long sendPixId;
    private Double value;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getReceiverPixId() {
        return receiverPixId;
    }

    public void setReceiverPixId(Long receiverPixId) {
        this.receiverPixId = receiverPixId;
    }

    public Long getSendPixId() {
        return sendPixId;
    }

    public void setSendPixId(Long sendPixId) {

        this.sendPixId = sendPixId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

   /* public Transaction toTransaction() {
        Transaction transaction = new Transaction();

        transaction.set
    }
*/
}
