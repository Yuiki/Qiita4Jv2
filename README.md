Qiita4Jv2
====
[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/Yuiki/Qiita4Jv2/blob/master/LICENSE)

[Qiita API v2](https://qiita.com/api/v2/docs) wrapper library for Java.

## Description
You can use Qiita API v2 easily by using this library.  
This library also supports Qiita API v2 for Qiita:Team.  

If you want to use [Qiita API v1](https://qiita.com/api/v1/docs) wrapper in Java, you could use [Qiita4j]("https://github.com/zaneli/qiita4j").

## Usage
##### Preparation
```Java
// If you want to target http://qiita.com/
Qiita qiita = QiitaFactory.getInstance();
// If you want to target http://team.qiita.com/
Qiita qiita = QiitaFactory.getInstance("team");

// Some GET requests can be used without setting the access token.
// However, in that case the Rate limit is set to a low value.
qiita.setAccessToken("accessToken");
```

##### Obtain a authorized url and new access token
You can issue a new access token in https://qiita.com/settings/tokens/new  
However, if you want to get an autorized page and a new access token, please follow the instructions below.
1. Create a new qiita application in https://qiita.com/settings/applications/new
2. Set the issued client id and client secret.
```Java
qiita.setClientInformation("client_id", "client_secret");
```
3. Call `Qiita#getAuthorizeUrl` and get an authorized url.  
You should set the access scope used by this application(space delimiter) and the any csrf token.
```Java
System.out.println("Authorize url:" + qiita.getAuthorizeUrl(/* scope */ "read_qiita read_qiita_team write_qiita write_qiita_team", "csrf_token"));
```

4. Set the code of the URL query of the redirect destination after authentication.
```Java
System.out.println("Access token:" + qiita.getAccessToken("code").getEntity().getToken());
```

##### QiitaResponse
```Java
QiitaResponse<User> userReponse = qiita.getUser("Yuiki");
User yuiki = userReponse.getEntity();
System.out.println(yuiki.getName());
System.out.println("Rate reset epoch time:" + response.getRateResetEpochTime());
System.out.println("Rate limit count:" + response.getRateLimitCount());
System.out.println("Rate remaining count" + response.getRateRemainingCount());
```

##### QiitaPageResponse
```Java
QiitaPageResponse<List<Item>> itemsResponse = qiita.getItemsByQuery(/* page */ 1, /* item amounts per page*/ 20, "Java");
List<Item> items = itemsResponse.getEntiry();
items.stream().map(Item::getTitle).forEach(System.out::println);
System.out.println("Total count:" itemsResponse.getTotalCount());
```

##### Error handling
Acctuary, when you use Qiita API by using this qiita instance, you should catch the QiitaException.  
If you want to the error details, you can use `QiitaException#getType` or `QiitaException#getMessage`.

## Download
I'm preparing to publish this library to mavenCentral.  
Stay tuned!
