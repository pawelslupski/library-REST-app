package com.crud.library.dao;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReaderDaoTestSuite {
    @Autowired
    private ReaderDao readerDao;

    @Test
    public void testReaderDaoSave() {
        //Given
        Reader reader = new Reader("Barbara", "Streisand");

        //When
        readerDao.save(reader);

        //Then
        int id = reader.getId();
        Reader readReader = readerDao.findOne(id);
        Assert.assertEquals(id, readReader.getId());

        //Cleanup
        readerDao.delete(id);
    }

    @Test
    public void testReaderDaoFindById() {
        //Given
        Reader reader = new Reader("Brian", "Riley");

        //When
        readerDao.save(reader);

        //Then
        int id = reader.getId();
        Optional<Reader> readReader = readerDao.findById(id);
        Assert.assertNotNull(readReader);
        Assert.assertEquals(id, readReader.get().getId());

        //Cleanup
        readerDao.delete(id);
    }
}
