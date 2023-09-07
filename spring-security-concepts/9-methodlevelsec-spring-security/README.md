jwt structure: header.payload.signature
****
1. header: algorithm, type
2. payload: user details,token info
3. signature(optional): prevents tempering of token by digitally signing it .
      - signature:HMACSHA256(base64UrlEncode(header)+"."+base64UrlEncode(payload),secret)
****