<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" indent="yes"/>
<xsl:template match="/">&lt;!DOCTYPE html&gt;
&lt;html&gt;
    &lt;head&gt;
      &lt;style type=&quot;text/css&quot;&gt;
      div {width:50px;height:60px;}
.divMain{display:block;position:absolute;x:0;y:0;width:100%;height:100%;overflow:auto;}
      &lt;/style&gt;
    &lt;/head&gt;
    &lt;body&gt;
&lt;div class=&quot;divMain&quot;&gt;
&lt;img src=&quot;Tasks.png&quot; style="position:absolute;display:block;left:0;top:0;"/&gt;
&lt;span style="position:absolute;display:block;left:0;top:0;width:1600px !important;height:1200px !important;"&gt;
<xsl:apply-templates select="*"></xsl:apply-templates>&lt;/span&gt;
&lt;/div&gt;

    &lt;/body&gt;
&lt;/html&gt;
</xsl:template>
<xsl:template match="*">
&lt;a <xsl:if test="@ExternalLinkURL!=''"> target=&quot;_blank&quot; href=&quot;<xsl:value-of select="@ExternalLinkURL"/>&quot;</xsl:if>&gt;
&lt;DIV ID=&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot; style=&quot;z-index:1;position:absolute;left:<xsl:value-of select="@XPos"/>px;width:50px;height:60px;top:<xsl:value-of select="@YPos"/>px;<xsl:if test="@ExternalLinkURL!=''">cursor:pointer;</xsl:if>&quot; title=&quot;<xsl:value-of select="@Notes"/>&quot;&gt;&lt;/DIV&gt;&lt;/a&gt;
 <xsl:apply-templates select="*"/></xsl:template>
</xsl:stylesheet>
