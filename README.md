# Steps to integrate the Right First Time SDK in your Android app


Add RFTCaptureSdk library to app gradle file: 
```gradle
dependencies { 
    implementation 'com.idfy:rftcapturesdk:+'
}
```

* Create an instance of RFTSdk 
  * Create an instance of RFTSdk using the init function
  * This will provide an instance of RFTSdk that can be used for different functionalities of SDK
  * It takes activity context, account id and token as parameters

```java
RFTSdk rftsdk = RFTSdk.init(context, "<accountID>", "<token>"); 
```

* Using RftSdkCallbackInterface 
  * Implement RftSdkCallbackInterface in an activity where you want to get bitmap image from RFTSdk
  * This interface will provide a callback function onImageCaptureSuccess where the SDK will send the image after processing in case of success

```java
@Override
public void onImageCaptureSuccess(Bitmap bitmap) { 
    //Use the result image as required 
} 
```

 * This interface will provide a callback function onImageCaptureFailure where the SDK will give the error message in case of failure

```java
@Override
public void onImageCaptureFailure(JSONObject jsonObject) { 
    //Failure reason 
}
```

* Capture Doc using RFTSdk 
  * Capture document image using the function - CaptureDocImage 
  * It will take activity context, document type and the instance of an activity that's implementing RftSdkCallbackInterface

```java
rftsdk.CaptureDocImage(context,"<docType>",callback); 
```

* Capture Face using RFTSdk 
  * Capture face image using the function - CaptureFaceImage 
  * It will take activity context and the instance of an activity that’s implementing RftSdkCallbackInterface

```java
rftsdk.CaptureFaceImage(context, callback); 
```

* Upload Image using RFTSdk 
  * Uploads the resultant bitmap image to the server
  * This function will return a self-link, which can be used to create... 
  * It takes account id, token, group id, document type and bitmap image as parameters 

```java
JSONObject result = rftsdk.UploadImage("<accountID>", "<token>", "<groupId>", "<docType>", bitmap); 
```

* Notes:
  * IDfy's Right First Time(RFT) SDK aids the [Verification and OCR APIs](http://api-docs.idfy.com/v2/) by ensuring the image captured is correct and match the requisite quality standards
  * To get your account id and token, drop an email to eve.support@idfy.com
