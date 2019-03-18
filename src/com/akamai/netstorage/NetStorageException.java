/*
 * Copyright 2014 Akamai Technologies http://developer.akamai.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akamai.netstorage;


import com.akamai.auth.RequestSigningException;

/**
 * Netstorage Exceptions are intended to differentiate between IO (Networking and File) exceptions
 *
 * @author colinb@akamai.com (Colin Bendell)
 */
public class NetStorageException extends RequestSigningException {

	private static final long serialVersionUID = 5716437270940718895L;
	private int responseCode = -1;

    public NetStorageException(String message) {
        super(message);
    }

    public NetStorageException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

	public NetStorageException(String message, int responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public NetStorageException(String message, Throwable cause) {
        super(message, cause);
        if(cause instanceof NetStorageException) {
           responseCode = ((NetStorageException) cause).getResponseCode();
        }
    }

    public int getResponseCode(){
    	return responseCode;
    }
}
