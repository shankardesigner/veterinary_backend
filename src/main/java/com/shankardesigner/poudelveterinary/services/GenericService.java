package com.shankardesigner.poudelveterinary.services;

import java.io.IOException;
import java.util.List;

public interface GenericService<T> {

    public T saveInfo(T t) throws IOException;

    public T updateInfo(T t);

    public boolean deleteInfo(long id);

    public List<T> getAllInfo();

    public T getInfoById(long id);
}
