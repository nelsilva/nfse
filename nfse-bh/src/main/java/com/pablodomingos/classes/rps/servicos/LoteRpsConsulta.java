package com.pablodomingos.classes.rps.servicos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pablodomingos.classes.rps.RpsPrestador;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ConsultarLoteRpsEnvio")
public class LoteRpsConsulta {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns = "http://www.abrasf.org.br/nfse.xsd";

  @XStreamAlias("Prestador")
  @NotNull
  private RpsPrestador prestador;

  @XStreamAlias("Protocolo")
  @NotNull
  @Size(max = 50)
  private String numeroProtocolo;
  
  public LoteRpsConsulta(String numeroProtocolo, RpsPrestador prestador) {
    super();
    this.numeroProtocolo = numeroProtocolo;
    this.prestador = prestador;
  }

  public String getNumeroProtocolo() {
    return numeroProtocolo;
  }

  public RpsPrestador getPrestador() {
    return prestador;
  }

  public String converterParaXml() {
    String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    
    XStream xstream = new XStream();
    xstream.setMode(XStream.NO_REFERENCES);
    xstream.autodetectAnnotations(true);
    
    return XML_HEADER + xstream.toXML(this);
  }
}
