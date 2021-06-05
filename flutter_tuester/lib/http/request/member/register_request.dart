import 'package:flutter_tuester/http/request/base_request.dart';

class RegisterRequest extends BaseRequest {
  @override
  bool needLogin() {
    return false;
  }

  @override
  String path() {
    return "/member/register";
  }

  @override
  RequestMethod requestMethod() {
    return RequestMethod.POST;
  }

}