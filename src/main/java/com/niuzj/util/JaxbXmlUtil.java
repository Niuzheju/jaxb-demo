package com.niuzj.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@SuppressWarnings("all")
public final class JaxbXmlUtil {

    public static <T> T xmlToObject(String xml, Class<T> cla) {
        T t = null;
        try {
            if (xml != null && !"".equals(xml) && cla != null){
                JAXBContext jaxbContext = JAXBContext.newInstance(cla);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                t = (T) unmarshaller.unmarshal(new StringReader(xml));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String ObjectToString(Object obj) {
        String xml = null;
        try {
            if (obj != null){
                JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                StringWriter stringWriter = new StringWriter();
                marshaller.marshal(obj, stringWriter);
                xml = stringWriter.toString();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
