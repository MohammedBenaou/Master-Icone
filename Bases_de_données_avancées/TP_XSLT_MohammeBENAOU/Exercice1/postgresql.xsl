<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" encoding="utf-8"/>
 
<xsl:template match="/">
 <xsl:apply-templates select="/database"/>
 <xsl:apply-templates select="//table"/>
 <xsl:apply-templates select="//table/index"/>
</xsl:template>

<xsl:template match="database">
	<xsl:text>CREATE DATABASE </xsl:text>
	<xsl:value-of select="@name"/>
	<xsl:text>;&#13;&#13;</xsl:text>
	<xsl:text>USE </xsl:text>
	<xsl:value-of select="@name"/>
	<xsl:text>;&#13;&#13;</xsl:text>
</xsl:template>
 
<xsl:template match="table">
	<xsl:text>CREATE TABLE </xsl:text>
	<xsl:value-of select="@name"/>
	<xsl:text>( </xsl:text>
	<xsl:apply-templates select="column" />
	<xsl:if test="foreign-key">
		<xsl:text>,&#13;FOREIGN KEY( </xsl:text>
		<xsl:value-of select="foreign-key/reference/@local"/>
		<xsl:text> ) REFERENCES </xsl:text>
		<xsl:value-of select="foreign-key/@foreignTable"/>
		<xsl:text> ( </xsl:text>
		<xsl:value-of select="foreign-key/reference/@foreign"/>
		<xsl:text> )</xsl:text>
	</xsl:if>
	<xsl:text> );&#13;&#13;</xsl:text>
</xsl:template>

<xsl:template match="table/index">
	<xsl:text>CREATE INDEX </xsl:text>
	<xsl:value-of select="@name"/>
	<xsl:text> ON </xsl:text>
	<xsl:value-of select="../@name"/>
	<xsl:text> ( </xsl:text>
	<xsl:value-of select="index-column/@name"/>
	<xsl:text> );&#13;&#13; </xsl:text>
</xsl:template>
 
 <xsl:template match="column">	
	<xsl:if test="not(position() = 1)"><xsl:text>,</xsl:text></xsl:if>
	<xsl:text>&#13;</xsl:text>
	<xsl:value-of select="@name"/>
	<xsl:text> </xsl:text>
	<xsl:choose>
		<xsl:when test="@type='INTEGER'">
			<xsl:text>INTEGER </xsl:text> 
		</xsl:when>
		<xsl:when test="@type='VARCHAR'">
			<xsl:text>VARCHAR(</xsl:text>
			<xsl:value-of select="@size"/>
			<xsl:text>) </xsl:text>
		</xsl:when>
	</xsl:choose>
	<xsl:if test="@autoIncrement='true'">AUTO_INCREMENT </xsl:if>
	<xsl:if test="@primaryKey='true'">PRIMARY KEY </xsl:if>
	<xsl:if test="@required='true'">NOT </xsl:if>
	<xsl:text>NULL </xsl:text>
	<xsl:if test="@defaultValue">DEFAULT '<xsl:value-of select="@defaultValue"/>' </xsl:if>
</xsl:template>
</xsl:stylesheet>