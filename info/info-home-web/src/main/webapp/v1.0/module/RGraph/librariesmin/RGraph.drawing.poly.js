
RGraph=window.RGraph||{isRGraph:true};RGraph.Drawing=RGraph.Drawing||{};RGraph.Drawing.Poly=function(conf)
{if(typeof conf==='object'&&typeof conf.coords==='object'&&typeof conf.id==='string'){var id=conf.id
var coords=conf.coords;var parseConfObjectForOptions=true;}else{var id=conf;var coords=arguments[1];}
this.id=id;this.canvas=document.getElementById(this.id);this.context=this.canvas.getContext('2d');this.colorsParsed=false;this.canvas.__object__=this;this.coords=coords;this.coordsText=[];this.original_colors=[];this.firstDraw=true;this.type='drawing.poly';this.isRGraph=true;this.uid=RGraph.CreateUID();this.canvas.uid=this.canvas.uid?this.canvas.uid:RGraph.CreateUID();this.properties={'chart.linewidth':1,'chart.strokestyle':'black','chart.fillstyle':'red','chart.events.click':null,'chart.events.mousemove':null,'chart.tooltips':null,'chart.tooltips.override':null,'chart.tooltips.effect':'fade','chart.tooltips.css.class':'RGraph_tooltip','chart.tooltips.event':'onclick','chart.tooltips.highlight':true,'chart.highlight.stroke':'rgba(0,0,0,0)','chart.highlight.fill':'rgba(255,255,255,0.7)','chart.shadow':false,'chart.shadow.color':'rgba(0,0,0,0.2)','chart.shadow.offsetx':3,'chart.shadow.offsety':3,'chart.shadow.blur':5}
if(!this.canvas){alert('[DRAWING.POLY] No canvas support');return;}
this.$0={};if(!this.canvas.__rgraph_aa_translated__){this.context.translate(0.5,0.5);this.canvas.__rgraph_aa_translated__=true;}
var RG=RGraph,ca=this.canvas,co=ca.getContext('2d'),prop=this.properties,pa=RG.Path,pa2=RG.path2,win=window,doc=document,ma=Math
if(RG.Effects&&typeof RG.Effects.decorate==='function'){RG.Effects.decorate(this);}
this.set=this.Set=function(name)
{var value=typeof arguments[1]==='undefined'?null:arguments[1];if(arguments.length===1&&typeof name==='object'){RG.parseObjectStyleConfig(this,name);return this;}
if(name.substr(0,6)!='chart.'){name='chart.'+name;}
name=name.replace(/([A-Z])/g,function(str)
{return'.'+String(RegExp.$1).toLowerCase();});prop[name]=value;return this;};this.get=this.Get=function(name)
{if(name.substr(0,6)!='chart.'){name='chart.'+name;}
name=name.replace(/([A-Z])/g,function(str)
{return'.'+String(RegExp.$1).toLowerCase()});return prop[name.toLowerCase()];};this.draw=this.Draw=function()
{RG.FireCustomEvent(this,'onbeforedraw');if(!this.colorsParsed){this.parseColors();this.colorsParsed=true;}
this.coordsText=[];var obj=this;pa(this,['b','fu',function(obj){if(prop['chart.shadow'])
{co.shadowColor=prop['chart.shadow.color'];co.shadowOffsetX=prop['chart.shadow.offsetx'];co.shadowOffsetY=prop['chart.shadow.offsety'];co.shadowBlur=prop['chart.shadow.blur'];}},'fu',function(obj)
{co.strokeStyle=prop['chart.strokestyle'];co.fillStyle=prop['chart.fillstyle'];obj.DrawPoly();},'lw',prop['chart.linewidth'],'f',prop['chart.fillstyle'],'fu',function()
{RG.NoShadow(obj);},'s',prop['chart.strokestyle']]);RG.NoShadow(this)
RG.InstallEventListeners(this);if(this.firstDraw){RG.fireCustomEvent(this,'onfirstdraw');this.firstDraw=false;this.firstDrawFunc();}
RG.FireCustomEvent(this,'ondraw');return this;};this.exec=function(func)
{func(this);return this;};this.getObjectByXY=function(e)
{if(this.getShape(e)){return this;}};this.drawPoly=this.DrawPoly=function()
{var coords=this.coords;pa(this,['b','m',coords[0][0],coords[0][1]]);for(var i=1,len=coords.length;i<len;++i){co.lineTo(coords[i][0],coords[i][1]);}
pa(this,['lw',prop['chart.linewidth'],'c','f',co.fillStyle,'s',co.strokeStyle]);};this.getShape=function(e)
{var coords=this.coords;var mouseXY=RGraph.getMouseXY(e);var mouseX=mouseXY[0];var mouseY=mouseXY[1];co.beginPath();co.strokeStyle='rgba(0,0,0,0)';co.fillStyle='rgba(0,0,0,0)';this.DrawPoly();if(co.isPointInPath(mouseX,mouseY)){return{0:this,1:this.coords,2:0,'object':this,'coords':this.coords,'index':0,'tooltip':prop['chart.tooltips']?prop['chart.tooltips'][0]:null};}
return null;};this.positionTooltip=function(obj,x,y,tooltip,idx)
{var canvasXY=RGraph.getCanvasXY(obj.canvas);var width=tooltip.offsetWidth;var height=tooltip.offsetHeight;tooltip.style.left=0;tooltip.style.top=(y-height-7)+'px';tooltip.style.overflow='';var img=new Image();img.src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABEAAAAFCAYAAACjKgd3AAAARUlEQVQYV2NkQAN79+797+RkhC4M5+/bd47B2dmZEVkBCgcmgcsgbAaA9GA1BCSBbhAuA/AagmwQPgMIGgIzCD0M0AMMAEFVIAa6UQgcAAAAAElFTkSuQmCC';img.style.position='absolute';img.id='__rgraph_tooltip_pointer__';img.style.top=(tooltip.offsetHeight-2)+'px';tooltip.appendChild(img);if(x-(width/2)<10){tooltip.style.left=(canvasXY[0]+x-(width*0.1))-8.5+'px';img.style.left=((width*0.1)-8.5)+'px';}else if((x+(width/2))>doc.body.offsetWidth){tooltip.style.left=x-(width*0.9)+'px';img.style.left=((width*0.9)-8.5)+'px';}else{tooltip.style.left=x-(width/2)+'px';img.style.left=((width*0.5)-8.5)+'px';}};this.highlight=this.Highlight=function(shape)
{co.fillStyle=prop['chart.fillstyle'];if(prop['chart.tooltips.highlight']){pa(this,['b','fu',function(obj){obj.DrawPoly();},'f',prop['chart.highlight.fill'],'s',prop['chart.highlight.stroke']]);}};this.parseColors=function()
{if(this.original_colors.length===0){this.original_colors['chart.fillstyle']=RG.array_clone(prop['chart.fillstyle']);this.original_colors['chart.strokestyle']=RG.array_clone(prop['chart.strokestyle']);this.original_colors['chart.highlight.stroke']=RG.array_clone(prop['chart.highlight.stroke']);this.original_colors['chart.highlight.fill']=RG.array_clone(prop['chart.highlight.fill']);}
var func=this.parseSingleColorForGradient;prop['chart.fillstyle']=func(prop['chart.fillstyle']);prop['chart.strokestyle']=func(prop['chart.strokestyle']);prop['chart.highlight.stroke']=func(prop['chart.highlight.stroke']);prop['chart.highlight.fill']=func(prop['chart.highlight.fill']);};this.reset=function()
{};this.parseSingleColorForGradient=function(color)
{if(!color){return color;}
if(typeof color==='string'&&color.match(/^gradient\((.*)\)$/i)){var parts=RegExp.$1.split(':');var grad=co.createLinearGradient(0,0,ca.width,0);var diff=1/(parts.length-1);grad.addColorStop(0,RG.trim(parts[0]));for(var j=1,len=parts.length;j<len;++j){grad.addColorStop(j*diff,RG.trim(parts[j]));}}
return grad?grad:color;};this.on=function(type,func)
{if(type.substr(0,2)!=='on'){type='on'+type;}
this[type]=func;return this;};this.firstDrawFunc=function()
{};RG.att(ca);RG.Register(this);if(parseConfObjectForOptions){RG.parseObjectStyleConfig(this,conf.options);}};