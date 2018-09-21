package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Type;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeRepositoryImplementationTest {

    private TypeRepositoryImplementation typeRepo = new TypeRepositoryImplementation();

    @Test
    public void get() {

        Type type = typeRepo.get(0L);

        assertEquals(type.getId(), Long.valueOf(0L));

        type = typeRepo.get(50L);

        assertNull(type);
    }

    @Test
    public void get1() {

        Type type = typeRepo.get("EXPENSE");

        assertEquals(type.getCode(), "EXPENSE");

        type = typeRepo.get("expense");

        assertEquals(type.getCode(), "EXPENSE");

        type = typeRepo.get("something");

        assertNull(type);
    }
}