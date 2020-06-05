//package org.petrveri.aw.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//@ConfigurationProperties(prefix = "spring.security.oauth2.client")
//public class SomeSecurityConfiguration {
//
//    private final static Logger log = LoggerFactory.getLogger(SomeSecurityConfiguration.class);
//
//    public SomeSecurityConfiguration() {
//        log.info("within OktaConfiguration");
////        HashMap<String, String> newenv = new HashMap<>();
////        newenv.put("OKTA_CLIENT_ID", "0oae3n79bB37lceql4x6");
////        newenv.put("OKTA_CLIENT_SECRET", "QlyWRhLNjtzYh_d6VxJyJSC8DJAjFvriG3-0PbFT");
////        newenv.put("OKTA_ISSUER_URI", "https://dev-377283.okta.com/oauth2/default");
////        try {
////            setEnv(newenv);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        log.info("ok: OKTA_CLIENT_ID:\t[{}]", System.getenv("OKTA_CLIENT_ID"));
////        log.info("ok: OKTA_CLIENT_SECRET:\t[{}]", System.getenv("OKTA_CLIENT_SECRET"));
////        log.info("ok: OKTA_ISSUER_URI:\t[{}]", System.getenv("OKTA_ISSUER_URI"));
//    }
//
////    registration:
////      okta:
////          client-id: ${OKTA_CLIENT_ID:okta_client_id_placeholder}
////          client-secret: ${OKTA_CLIENT_SECRET:okta_client_secret_placeholder}
////          scope: openid, email, profile
////    provider:
////      okta:
////          issuer-uri: ${OKTA_ISSUER_URI:okta_issuer_uri_placeholder}
//    private final Registration registration = new Registration();
//
//    private final Provider provider = new Provider();
//
//    public Registration getRegistration() {
//        log.info("ok: get Registration");
//        return  registration;
//    }
//
//    public Provider getProvider() {
//        log.info("ok: get Provider");
//        return  provider;
//    }
//
//    public static class Registration {
//
//        private final Okta okta = new Okta();
//
//        public Okta getOkta() {
//            log.info("ok: get Okta");
//            return okta;
//        }
//
//        public static class Okta {
//            private String clientId = "0oae3n79bB37lceql4x6";
//
//            private String clientSecret = "QlyWRhLNjtzYh_d6VxJyJSC8DJAjFvriG3-0PbFT";
//
//            private List<String> scope = Arrays.asList("openid", "email", "profile");
//
//            public String getClientId() {
//                clientId = "0oae3n79bB37lceql4x6";
//                log.info("ok: getClientId:\t[{}]", clientId);
//                return clientId;
//            }
//
//            public void setClientId(String clientId) {
//                log.info("ok: setClientId:\t[{}]", clientId);
////                this.clientId = clientId;
//            }
//
//            public String getClientSecret() {
//                clientSecret = "QlyWRhLNjtzYh_d6VxJyJSC8DJAjFvriG3-0PbFT";
//                log.info("ok: getClientSecret:\t[{}]", clientSecret);
//                return clientSecret;
//            }
//
//            public void setClientSecret(String clientSecret) {
//                log.info("ok: setClientSecret:\t[{}]", clientSecret);
////                this.clientSecret = clientSecret;
//            }
//
//            public List<String> getScope() {
//                log.info("ok: getScope:\t[{}]", scope);
//                return scope;
//            }
//
//            public void setScope(List<String> scope) {
//                log.info("ok: setScope:\t[{}]", scope);
////                this.scope = scope;
//            }
//        }
//    }
//
//    public static class Provider {
//
//        private final Okta okta = new Okta();
//
//        public Okta getOkta() {
//            log.info("ok: get Okta");
//            return okta;
//        }
//
//        public static class Okta {
//            private String issuerUri = "https://dev-377283.okta.com/oauth2/default";
//
//            public String getIssuerUri() {
//                issuerUri = "https://dev-377283.okta.com/oauth2/default";
//                log.info("ok: getIssuerUri:\t[{}]", issuerUri);
//                return issuerUri;
//            }
//
//            public void setIssuerUri(String issuerUri) {
//                log.info("ok: setIssuerUri:\t[{}]", issuerUri);
////                this.issuerUri = issuerUri;
//            }
//        }
//    }
//
////    protected static void setEnv(Map<String, String> newenv) throws Exception {
////        try {
////            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
////            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
////            theEnvironmentField.setAccessible(true);
////            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
////            env.putAll(newenv);
////            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
////            theCaseInsensitiveEnvironmentField.setAccessible(true);
////            Map<String, String> cienv = (Map<String, String>)     theCaseInsensitiveEnvironmentField.get(null);
////            cienv.putAll(newenv);
////        } catch (NoSuchFieldException e) {
////            Class[] classes = Collections.class.getDeclaredClasses();
////            Map<String, String> env = System.getenv();
////            for(Class cl : classes) {
////                if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
////                    Field field = cl.getDeclaredField("m");
////                    field.setAccessible(true);
////                    Object obj = field.get(env);
////                    Map<String, String> map = (Map<String, String>) obj;
////                    map.clear();
////                    map.putAll(newenv);
////                }
////            }
////        }
////    }
//}
