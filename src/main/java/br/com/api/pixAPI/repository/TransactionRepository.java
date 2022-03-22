package br.com.api.pixAPI.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.api.pixAPI.model.Transaction;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long>{

}
