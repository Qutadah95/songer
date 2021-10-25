package com.example.songr;

import com.example.songr.model.AlbumModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test void testAlbum(){

		AlbumModel album1=new AlbumModel("album1","Adil",1,1,"https://upload.wikimedia.org/wikipedia/en/1/1b/Adele_-_21.png");
		Assertions.assertEquals("AlbumModel{title='album1', artist='Adil', songCount=1, length=1, imageUrl='https://upload.wikimedia.org/wikipedia/en/1/1b/Adele_-_21.png'}",album1.toString());
	}


}
