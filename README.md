# money-transfer

## Over view

This repository has Java source codes to provide RESTful API.

The API provide several features to do money transfers.

## Requirements

- Tomcat as API server
- JRE 8

## API URI

### Authorization

All APIs require `Authorization` in HTTP header. <br>
It simulate a user token which is supposed to be generated and authorized in any login processes.<br>
But unfortunately there are no login flow here.

So please use following parameters as `Authorization` for each test users as if you already got the authorization.<br>
Based on `Authorization` in HTTP header, the user is specified for each API. 


|No |User|parameter|
|:--:|:--:|:--:|
|1 |USER_1|43dee228-8776-4860-a6f1-16691e1476ad|
|1 |USER_2|09514406-85fd-4edb-b437-d7c888ec1476|

Example in HTTP header in your request
```
Authorization:43dee228-8776-4860-a6f1-16691e1476ad
```


Followings are API URIs. 

### Accounts

- *GET /money-transfer/api/accounts*

    Please use this API to get account information of the user whom you use.

    #### Response Example
    ```
    {
        "accounts": [
            {
                "accountId": 1001,
                "balance": 11945,
                "currency": "JPY",
                "userId": 1000
            },
            {
                "accountId": 1002,
                "balance": 23945,
                "currency": "JPY",
                "userId": 1000
            }
        ]
    }
    ```

### Transfers

- *GET /money-transfer/api/transfers*

    Please use this API to get transfer information.

    #### Response Example

    ```
    {
        "transfers": [
            {
                "ammount": 1500,
                "frAccountId": 1002,
                "toAccountId": 2001,
                "transferDate": "2019-04-07T18:31:31.667Z[UTC]",
                "transferId": "2c9643a8-e372-4f7a-8c22-7db397fa48ca",
                "transferStatus": "PLACED",
                "userId": 1000
            },
            {
                "ammount": 55,
                "frAccountId": 1001,
                "toAccountId": 2001,
                "transferDate": "2019-04-07T18:31:31.689Z[UTC]",
                "transferId": "e7d8e981-0c7a-4d2c-97fe-5f8efd0a854c",
                "transferStatus": "APPROVED",
                "userId": 1000
            }
        ]
    }
    ```

- *POST /money-transfer/api/transfers*

    Please use this API to start a transaction of money transfer.

    #### Required Request Body Parameters 
    ```
    "ammount": Number,
    "frAccountId": Number,
    "toAccountId": Number,
    "transferStatus": "PLACED"
    ```

    Request Example

    ```
    POST /money-transfer/api/transfers
    {
        "ammount": 500,
        "frAccountId": 1002,
        "toAccountId": 2001,
        "transferStatus": "PLACED"
    }
    ```

    #### Response Example
    ```
    {
        "transfers": [
            {
                "ammount": 55,
                "frAccountId": 1002,
                "toAccountId": 2001,
                "transferDate": "2019-04-07T19:11:18.558Z[UTC]",
                "transferId": "b09998ee-51df-412d-a1e0-d6cd6d5c741d",
                "transferStatus": "PLACED",
                "userId": 1000
            }
        ]
    }
    ```

- *PUT /money-transfer/api/transfers/{transferId}*

    Please use this API to confirm the transaction which you created.<br>
    After this API finished, money for each account is suppose to be moved.

    Required Request Body
    ```
    "transferStatus": "APPROVED"
    ```

    Request Example
    ```
    PUT /money-transfer/api/transfers/a4ee1ff2-241c-4a8d-bb1c-f309836494ea
    {
        "transferStatus": "APPROVED"
    }
    ```
