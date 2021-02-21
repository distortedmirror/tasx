<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" indent="yes"/>
<xsl:template match="Tasx">&lt;!DOCTYPE html&gt;
&lt;html&gt;
&lt;head&gt;
&lt;style type=&quot;text/css&quot;&gt;
img {width:50px;height:60px;}
&lt;/style&gt;
&lt;/head&gt;
&lt;body&gt;<xsl:apply-templates select="*"></xsl:apply-templates>&lt;/body&gt;
&lt;/html&gt;
</xsl:template>

<xsl:template match="*">
&lt;img ID=&quot;<xsl:value-of select="@Name"/>&quot; src=&quot;&quot;/&gt;
<xsl:apply-templates select="*"/></xsl:template>
</xsl:stylesheet>
