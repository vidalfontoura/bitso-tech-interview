package com.bitso.interview.project.repository;

import com.bitso.interview.project.domain.TinyURL;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TinyURLRepository  extends PagingAndSortingRepository<TinyURL, Long> {


}
