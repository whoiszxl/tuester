import 'package:flutter_tuester/http/request/base_request.dart';

///微博列表信息请求类
class BlogListRequest extends BaseRequest {

  @override
  bool needLogin() {
    return true;
  }

  @override
  String path() {
    return "/microblog/blog/list";
  }

  @override
  RequestMethod requestMethod() {
    return RequestMethod.POST;
  }
}