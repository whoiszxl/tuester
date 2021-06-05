class MemberDetailModel {
  int id;
  String username;
  String password;
  String avatar;
  String nickname;
  String googleKey;
  int googleStatus;
  String realName;
  String email;
  String phone;
  int online;
  int status;
  String createdAt;
  String updatedAt;
  Null profilePhoto;
  int gender;
  String birthday;
  String countryCode;
  String country;
  String province;
  String city;
  String district;
  String gradeLevel;
  int loginCount;
  int loginErrorCount;
  String lastLogin;

  MemberDetailModel(
      {this.id,
        this.username,
        this.password,
        this.avatar,
        this.nickname,
        this.googleKey,
        this.googleStatus,
        this.realName,
        this.email,
        this.phone,
        this.online,
        this.status,
        this.createdAt,
        this.updatedAt,
        this.profilePhoto,
        this.gender,
        this.birthday,
        this.countryCode,
        this.country,
        this.province,
        this.city,
        this.district,
        this.gradeLevel,
        this.loginCount,
        this.loginErrorCount,
        this.lastLogin});

  MemberDetailModel.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    username = json['username'];
    password = json['password'];
    avatar = json['avatar'];
    nickname = json['nickname'];
    googleKey = json['googleKey'];
    googleStatus = json['googleStatus'];
    realName = json['realName'];
    email = json['email'];
    phone = json['phone'];
    online = json['online'];
    status = json['status'];
    createdAt = json['createdAt'];
    updatedAt = json['updatedAt'];
    profilePhoto = json['profilePhoto'];
    gender = json['gender'];
    birthday = json['birthday'];
    countryCode = json['countryCode'];
    country = json['country'];
    province = json['province'];
    city = json['city'];
    district = json['district'];
    gradeLevel = json['gradeLevel'];
    loginCount = json['loginCount'];
    loginErrorCount = json['loginErrorCount'];
    lastLogin = json['lastLogin'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['username'] = this.username;
    data['password'] = this.password;
    data['avatar'] = this.avatar;
    data['nickname'] = this.nickname;
    data['googleKey'] = this.googleKey;
    data['googleStatus'] = this.googleStatus;
    data['realName'] = this.realName;
    data['email'] = this.email;
    data['phone'] = this.phone;
    data['online'] = this.online;
    data['status'] = this.status;
    data['createdAt'] = this.createdAt;
    data['updatedAt'] = this.updatedAt;
    data['profilePhoto'] = this.profilePhoto;
    data['gender'] = this.gender;
    data['birthday'] = this.birthday;
    data['countryCode'] = this.countryCode;
    data['country'] = this.country;
    data['province'] = this.province;
    data['city'] = this.city;
    data['district'] = this.district;
    data['gradeLevel'] = this.gradeLevel;
    data['loginCount'] = this.loginCount;
    data['loginErrorCount'] = this.loginErrorCount;
    data['lastLogin'] = this.lastLogin;
    return data;
  }
}
