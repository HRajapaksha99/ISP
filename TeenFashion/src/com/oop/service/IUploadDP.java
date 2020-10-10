package com.oop.service;

import com.oop.model.Image;

import java.util.logging.Logger;

public interface IUploadDP {

	void uploadImage(Image image);
	byte[] getPhotos(String username);



}
