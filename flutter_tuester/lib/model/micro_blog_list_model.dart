class MicroBlogListModel {
  List<Content> content;
  int totalPages;
  int number;
  int size;
  bool first;

  MicroBlogListModel(
      {this.content, this.totalPages, this.number, this.size, this.first});

  MicroBlogListModel.fromJson(Map<String, dynamic> json) {
    if (json['content'] != null) {
      content = new List<Content>();
      json['content'].forEach((v) {
        content.add(new Content.fromJson(v));
      });
    }
    totalPages = json['totalPages'];
    number = json['number'];
    size = json['size'];
    first = json['first'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.content != null) {
      data['content'] = this.content.map((v) => v.toJson()).toList();
    }
    data['totalPages'] = this.totalPages;
    data['number'] = this.number;
    data['size'] = this.size;
    data['first'] = this.first;
    return data;
  }
}

class Content {
  Null id;
  Null memberId;
  String memberNickname;
  String memberAvatar;
  String blogText;
  String blogImgs;
  String blogVideo;
  String at;
  Null watch;
  Null like;
  int commentCount;
  Null from;
  String address;
  int status;
  String createdAt;
  String updatedAt;

  Content(
      {this.id,
        this.memberId,
        this.memberNickname,
        this.memberAvatar,
        this.blogText,
        this.blogImgs,
        this.blogVideo,
        this.at,
        this.watch,
        this.like,
        this.commentCount,
        this.from,
        this.address,
        this.status,
        this.createdAt,
        this.updatedAt});

  Content.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    memberId = json['memberId'];
    memberNickname = json['memberNickname'];
    memberAvatar = json['memberAvatar'];
    blogText = json['blogText'];
    blogImgs = json['blogImgs'];
    blogVideo = json['blogVideo'];
    at = json['at'];
    watch = json['watch'];
    like = json['like'];
    commentCount = json['commentCount'];
    from = json['from'];
    address = json['address'];
    status = json['status'];
    createdAt = json['createdAt'];
    updatedAt = json['updatedAt'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['memberId'] = this.memberId;
    data['memberNickname'] = this.memberNickname;
    data['memberAvatar'] = this.memberAvatar;
    data['blogText'] = this.blogText;
    data['blogImgs'] = this.blogImgs;
    data['blogVideo'] = this.blogVideo;
    data['at'] = this.at;
    data['watch'] = this.watch;
    data['like'] = this.like;
    data['commentCount'] = this.commentCount;
    data['from'] = this.from;
    data['address'] = this.address;
    data['status'] = this.status;
    data['createdAt'] = this.createdAt;
    data['updatedAt'] = this.updatedAt;
    return data;
  }
}
