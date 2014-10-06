

/**
 * STSServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.toastcoders.sso;

    /*
     *  STSServiceTest Junit test case
    */

    public class STSServiceTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testrenew() throws java.lang.Exception{

        com.toastcoders.sso.STSServiceStub stub =
                    new com.toastcoders.sso.STSServiceStub();//the default implementation should point to the right endpoint

           com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken21=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken21 here
                
                        assertNotNull(stub.renew(
                        requestSecurityToken21));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartrenew() throws java.lang.Exception{
            com.toastcoders.sso.STSServiceStub stub = new com.toastcoders.sso.STSServiceStub();
             com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken21=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken21 here
                

                stub.startrenew(
                         requestSecurityToken21,
                    new tempCallbackN1000C()
                );
              


        }

        private class tempCallbackN1000C  extends com.toastcoders.sso.STSServiceCallbackHandler{
            public tempCallbackN1000C(){ super(null);}

            public void receiveResultrenew(
                         com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse result
                            ) {
                
            }

            public void receiveErrorrenew(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testchallenge() throws java.lang.Exception{

        com.toastcoders.sso.STSServiceStub stub =
                    new com.toastcoders.sso.STSServiceStub();//the default implementation should point to the right endpoint

           com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse requestSecurityTokenResponse23=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse.class);
                    // TODO : Fill in the requestSecurityTokenResponse23 here
                
                        assertNotNull(stub.challenge(
                        requestSecurityTokenResponse23));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartchallenge() throws java.lang.Exception{
            com.toastcoders.sso.STSServiceStub stub = new com.toastcoders.sso.STSServiceStub();
             com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse requestSecurityTokenResponse23=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse.class);
                    // TODO : Fill in the requestSecurityTokenResponse23 here
                

                stub.startchallenge(
                         requestSecurityTokenResponse23,
                    new tempCallbackN10037()
                );
              


        }

        private class tempCallbackN10037  extends com.toastcoders.sso.STSServiceCallbackHandler{
            public tempCallbackN10037(){ super(null);}

            public void receiveResultchallenge(
                         com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponseCollection result
                            ) {
                
            }

            public void receiveErrorchallenge(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testvalidate() throws java.lang.Exception{

        com.toastcoders.sso.STSServiceStub stub =
                    new com.toastcoders.sso.STSServiceStub();//the default implementation should point to the right endpoint

           com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken25=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken25 here
                
                        assertNotNull(stub.validate(
                        requestSecurityToken25));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartvalidate() throws java.lang.Exception{
            com.toastcoders.sso.STSServiceStub stub = new com.toastcoders.sso.STSServiceStub();
             com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken25=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken25 here
                

                stub.startvalidate(
                         requestSecurityToken25,
                    new tempCallbackN10062()
                );
              


        }

        private class tempCallbackN10062  extends com.toastcoders.sso.STSServiceCallbackHandler{
            public tempCallbackN10062(){ super(null);}

            public void receiveResultvalidate(
                         com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse result
                            ) {
                
            }

            public void receiveErrorvalidate(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testissue() throws java.lang.Exception{

        com.toastcoders.sso.STSServiceStub stub =
                    new com.toastcoders.sso.STSServiceStub();//the default implementation should point to the right endpoint

           com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken27=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken27 here
                
                        assertNotNull(stub.issue(
                        requestSecurityToken27));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartissue() throws java.lang.Exception{
            com.toastcoders.sso.STSServiceStub stub = new com.toastcoders.sso.STSServiceStub();
             com.toastcoders.sso.STSServiceStub.RequestSecurityToken requestSecurityToken27=
                                                        (com.toastcoders.sso.STSServiceStub.RequestSecurityToken)getTestObject(com.toastcoders.sso.STSServiceStub.RequestSecurityToken.class);
                    // TODO : Fill in the requestSecurityToken27 here
                

                stub.startissue(
                         requestSecurityToken27,
                    new tempCallbackN1008D()
                );
              


        }

        private class tempCallbackN1008D  extends com.toastcoders.sso.STSServiceCallbackHandler{
            public tempCallbackN1008D(){ super(null);}

            public void receiveResultissue(
                         com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponseCollection result
                            ) {
                
            }

            public void receiveErrorissue(java.lang.Exception e) {
                fail();
            }

        }
      
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

    }
    