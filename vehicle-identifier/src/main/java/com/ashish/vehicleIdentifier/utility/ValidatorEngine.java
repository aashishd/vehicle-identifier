package com.ashish.vehicleIdentifier.utility;

import org.springframework.web.multipart.MultipartFile;

import com.ashish.vehicleIdentifier.exceptions.BusinessException;
import com.ashish.vehicleIdentifier.exceptions.ErrorCodes;

public class ValidatorEngine{
	
		public static void validateFileInput(MultipartFile file) throws BusinessException
		{
			if (CommonUtil.isNull(file) || file.isEmpty())
			{
				throw new BusinessException(ErrorCodes.E006.name(), ErrorCodes.E006.getMessage());
			}
		    String extension = "";
		    if(file.getOriginalFilename().contains(Constants.DOT_SEPARATOR))
		    {
		    	extension = file.getOriginalFilename().split("\\.")[1];
		    }
		    if (!Constants.ALLOWED_EXTENSIONS.contains(extension))
		    {
		        throw new BusinessException(ErrorCodes.E003.name(), ErrorCodes.E003.getMessage());
		    }
		}
}
