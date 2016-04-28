package com.chrismuldoon.development.services;

import javax.ejb.Local;


@Local
public interface LoadService {
	public void LoadData(String filename);
}
