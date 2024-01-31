package backup_ass_1.Controller;
// package Assignment_1_Newyear.Controller;

// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;

// import javax.imageio.ImageTranscoder;

// public class SVGApi {

//     public static BufferedImage rasterize(File svgFile) throws IOException {

//         final BufferedImage[] imagePointer = new BufferedImage[1];

//         // Rendering hints can't be set programatically, so
//         // we override defaults with a temporary stylesheet.
//         // These defaults emphasize quality and precision, and
//         // are more similar to the defaults of other SVG viewers.
//         // SVG documents can still override these defaults.
//         String css = "svg {" +
//                 "shape-rendering: geometricPrecision;" +
//                 "text-rendering:  geometricPrecision;" +
//                 "color-rendering: optimizeQuality;" +
//                 "image-rendering: optimizeQuality;" +
//                 "}";
//         File cssFile = File.createTempFile("batik-default-override-", ".css");
//         FileUtils.writeStringToFile(cssFile, css);

//         TranscodingHints transcoderHints = new TranscodingHints();
//         transcoderHints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, Boolean.FALSE);
//         transcoderHints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION,
//                 SVGDOMImplementation.getDOMImplementation());
//         transcoderHints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI,
//                 SVGConstants.SVG_NAMESPACE_URI);
//         transcoderHints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, "svg");
//         transcoderHints.put(ImageTranscoder.KEY_USER_STYLESHEET_URI, cssFile.toURI().toString());

//         try {

//             TranscoderInput input = new TranscoderInput(new FileInputStream(svgFile));

//             ImageTranscoder t = new ImageTranscoder() {

//                 @Override
//                 public BufferedImage createImage(int w, int h) {
//                     return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//                 }

//                 @Override
//                 public void writeImage(BufferedImage image, TranscoderOutput out)
//                         throws TranscoderException {
//                     imagePointer[0] = image;
//                 }
//             };
//             t.setTranscodingHints(transcoderHints);
//             t.transcode(input, null);
//         } catch (TranscoderException ex) {
//             // Requires Java 6
//             ex.printStackTrace();
//             throw new IOException("Couldn't convert " + svgFile);
//         } finally {
//             cssFile.delete();
//         }

//         return imagePointer[0];
//     }
// }
