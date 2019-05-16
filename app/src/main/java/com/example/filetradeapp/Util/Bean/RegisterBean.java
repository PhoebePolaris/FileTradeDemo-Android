package com.example.filetradeapp.Util.Bean;

public class RegisterBean {

    /**
     * resId : c6862acc-6a1e-40ff-8abc-c1420595723f
     * reqId : null
     * reqType : null
     * resResult : {"curData":{"userId":"acbeed8b-8295-4364-8c2d-2340a92642ce","username":"Ophelia","sex":1,"phone":"12321","email":"123456789@qq.com","avatar":null},"isSuccess":true,"message":"请求成功"}
     * resRefData : null
     */

    private String resId;
    private Object reqId;
    private Object reqType;
    private ResResultBean resResult;
    private Object resRefData;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public Object getReqId() {
        return reqId;
    }

    public void setReqId(Object reqId) {
        this.reqId = reqId;
    }

    public Object getReqType() {
        return reqType;
    }

    public void setReqType(Object reqType) {
        this.reqType = reqType;
    }

    public ResResultBean getResResult() {
        return resResult;
    }

    public void setResResult(ResResultBean resResult) {
        this.resResult = resResult;
    }

    public Object getResRefData() {
        return resRefData;
    }

    public void setResRefData(Object resRefData) {
        this.resRefData = resRefData;
    }

    public static class ResResultBean {
        /**
         * curData : {"userId":"acbeed8b-8295-4364-8c2d-2340a92642ce","username":"Ophelia","sex":1,"phone":"12321","email":"123456789@qq.com","avatar":null}
         * isSuccess : true
         * message : 请求成功
         */

        private CurDataBean curData;
        private boolean isSuccess;
        private String message;

        public CurDataBean getCurData() {
            return curData;
        }

        public void setCurData(CurDataBean curData) {
            this.curData = curData;
        }

        public boolean isIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public static class CurDataBean {
            /**
             * userId : acbeed8b-8295-4364-8c2d-2340a92642ce
             * username : Ophelia
             * sex : 1
             * phone : 12321
             * email : 123456789@qq.com
             * avatar : null
             */

            private String userId;
            private String username;
            private String phone;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }


            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

        }
    }
}
