<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:rng="http://relaxng.org/ns/structure/1.0">
    <xsl:template match="rng:grammar">
    <xsl:apply-templates/>}<xsl:text disable-output-escaping="yes">}</xsl:text>
  </xsl:template>
 
  <xsl:template match="rng:start">
    <xsl:text disable-output-escaping="yes">{ " </xsl:text><xsl:value-of select="child::*/attribute::name"/><xsl:text disable-output-escaping="yes">" :{</xsl:text>
  </xsl:template>
  
  <xsl:template match="rng:ref [@name]">
    <xsl:value-of select="@name"/>
    <xsl:if test="name(parent::*)='interleave'"></xsl:if>
    <xsl:if test="name(parent::*)='optional'"></xsl:if>
    <xsl:if test="name(parent::*)='ZeroOrMore'"></xsl:if>
    <xsl:if test="name(parent::*)='OneOrMore'"></xsl:if>
  </xsl:template>
  <xsl:template match="rng:define">
    <xsl:apply-templates select="rng:element"/>
  </xsl:template>
  
  <xsl:template match="rng:optional">
    <xsl:apply-templates/>
  </xsl:template>
  
  <xsl:template match="rng:OneOrMore">
    <xsl:apply-templates/>
  </xsl:template>
  
  <xsl:template match="rng:ZeroOrMore">
    <xsl:apply-templates/>
  </xsl:template>
  
  <xsl:template match="rng:element [@name]">
    <xsl:text disable-output-escaping="yes">"</xsl:text><xsl:value-of select="@name"/>" :{<xsl:apply-templates/>}<xsl:text disable-output-escaping="yes"></xsl:text>
  </xsl:template>
  
  <xsl:template match="rng:attribute [@name]">
    <xsl:text disable-output-escaping="yes">"</xsl:text><xsl:value-of select="@name"/>" :" <xsl:apply-templates/> ",<xsl:text disable-output-escaping="yes"></xsl:text>
  </xsl:template>
  <xsl:template match="rng:ref [@name]">
    <xsl:text disable-output-escaping="yes">"</xsl:text><xsl:value-of select="@name"/>" :" <xsl:apply-templates/> ",<xsl:text disable-output-escaping="yes"></xsl:text>
  </xsl:template>
  
</xsl:stylesheet>
