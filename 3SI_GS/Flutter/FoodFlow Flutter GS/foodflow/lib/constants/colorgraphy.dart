import 'dart:ui';

class ThemeColorsFactory {
  final Map<Brightness, IColorgraphy> map = {
    Brightness.light: Colorgraphy(),
    Brightness.dark: Colorgraphy()
  };

  IColorgraphy create(Brightness type) {
    if (!map.containsKey(type)) {
      throw Exception('brightness type not found');
    }

    return map[type] as IColorgraphy;
  }
}

abstract class IColorgraphy {
  late Color kPrimaryColor;
  late Color kAccentColor;
  late Color kBackgroundColor;
  late Color kDisabledColor;
  late Color kTextPrimaryColor;
  late Color kTextSecondaryColor;
}

class Colorgraphy implements IColorgraphy {
  @override
  late Color kPrimaryColor = const Color(0xff0D161E);
  @override
  late Color kAccentColor = const Color(0xFF0E4F24);
  @override
  late Color kBackgroundColor = const Color(0xffFDFDFD);
  @override
  late Color kDisabledColor = const Color(0xffC3C3C3);
  @override
  late Color kTextPrimaryColor = const Color(0xff292929);
  @override
  late Color kTextSecondaryColor = const Color(0xFF0E4F24);
}
