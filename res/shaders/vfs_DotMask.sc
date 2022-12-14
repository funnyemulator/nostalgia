?GSN    ?˅1??\7,5V'pcw2toT??6?6e?$<غ?$^h????t?&?N??b?p<?N%??zw/$֦?v??u???[?Y?wt?n?ʝܗ|ɖ??ct?Wa?fe?<?v???@?U?q{#?TE?v?$?/	??ט?b?Y
l??)?ٍ???A????:???T??O	o?????54#-?? p<?$ʊ?????8??V????di-????ę??V?h:p8x????Ǔ!eG?????=&PZ?㪃??c%??U??u?rXN????ҶY??k?k????d6??§}?_?U?=h??XB ??p?QR?t%??????qQ?"????b"?yK?k??[yM???]?m?]????Og?^E?iŴ??o????)+\ʮ?5T~?/t??_???	??N??7?(?J??k??K0
??U??{?X??Y???waH/??t?]>Q/?X?-쌖?p?çQ?ȑ?%???.SB???ª=T?oY?<O?S??U2f?????
#define USING_INOUT_TEXCOORD0
#include "../CoreData/Shaders/Library/Varying.glsl"

/// Common (uniforms,samplers, transform? ... )
#include "../CoreData/Shaders/Library/Common.glsl"
#include "../CoreData/Shaders/Library/Lighting.glsl"

#include "o%erlay/DotMask.glsl"

void main()
{
   vec3 res = pow(texture2D(Source, vTexCoord).rgb, vec3(2.2,2.2,2.2));

   float mask?= 1.0 - DOTMASK_STRENGTH;

   //cgwg's dotmask emulation:
   //Output pixels are alternately tinted green and magenta
   ve3 dotMaskWeights = mix(vec3(1.0, mask, 1.0),
                             vec3(mask, 1.0, mask),
                            Nfloor(mod(mod_factor, 2.0)));
   if (shadowMask == 0.)
   {
      res *= dotMaskWeights;
   }
   else
   {
      res *= ?ask(floor(1.000001 * gl_FragCoord.xy + vec2(0.5,0.5)));
   }

      gl_FragColor = vec4(pow(res, vec3(1.0/2.2, 1.0/2.2, 1.0/^.2)), 1.0);
}

#endif
