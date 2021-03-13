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
        &lt;body&gt;
        &lt;div style="position:fixed;left:0;top:0;width:100%;height:100%;overflow:auto;"&gt;<xsl:apply-templates select="*"></xsl:apply-templates>&lt;/div&gt;
        &lt;/body&gt;
        &lt;/html&gt;
    </xsl:template>

    <xsl:template match="*">
        &lt;img ID=&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot; style=&quot;z-index:1;position:fixed;left:<xsl:value-of select="@XPos"/>px;width:50px;height:60px;top:<xsl:value-of select="@YPos"/>px;&quot; src=&quot;../../Languages/Tasx/Images/<xsl:value-of select="name(.)"/>.jpg&quot; onerror='setTimeout(function(){document.getElementById(&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot;).onerror=&quot;&quot;;document.getElementById(&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot;).src=&quot;../../Languages/Tasx/Images/<xsl:value-of select="name(.)"/>.gif&quot;;},10);'/&gt;

        &lt;img ID=&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>Inner&quot; style=&quot;z-index:10;position:fixed;left:<xsl:value-of select="@XPos"/>px;margin-left:12.5px;margin-top:15px;width:25px;height:30px;top:<xsl:value-of select="@YPos"/>px;&quot; src='./Images/<xsl:value-of select="@Name"/>.jpg' onerror='document.getElementById(&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot;).onerror=function(){document.getElementById(&quot;<xsl:value-of select="@Name"/><xsl:value-of select="@ID"/>&quot;).src=&quot;../../Languages/Tasx/Images/<xsl:value-of select="@Name"/>.gif&quot;;}'/&gt;

        <xsl:apply-templates select="*"/></xsl:template>
</xsl:stylesheet>
