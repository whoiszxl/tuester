## JWT公私钥生成

1. 执行命令生成JKS私钥文件
```shell script
# 指定名称和密码生成RSA私钥
keytool.exe -genkeypair -alias tuester -keyalg RSA -keypass tuester -keystore tuester.jks -validity 365 -storepass tuester
```

2. 解析公钥
```shell script
keytool.exe -list -rfc --keystore tuester.jks | openssl x509 -inform pem -pubkey
```

3. 将公钥拷贝到文件里并复制到当前的resource下
```shell script
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhD+Y3Q7J5VfqmgNowyAU
M+3AwQlL1iSSmINyVZXV/czMrJHEXqlYWjJ8pe5YSBVY3Xam2iNZ26zE0Tkv1hpZ
LATGgEvZ3RS3X3mInWMGp4aCjNCYluelh31BggaDzjx+eeoamHHRISpGgjZNGlOq
8OyDsPvQgckP7XQ3jCzX6dkB5Hs4aDkrK0eODWoU3q+NpNQCMZuyJgrNF1YgigUU
WBSYqpao8d7Ubn/dop38GnBwKzh5GXw4SNFuByZQy1dunwW/0xqs/lpaFZ8c2DAS
fpYsqT0iq9tGLJ9OftbRCnnoOVJ9mlYVEOkanQpcU6xn+zDuQWdrCgpyIUyqIxtF
UQIDAQAB
-----END PUBLIC KEY-----
```