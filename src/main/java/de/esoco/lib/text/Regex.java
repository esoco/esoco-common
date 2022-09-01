package de.esoco.lib.text;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class Regex implements CharSequence {
    public enum RegexFlag {
        CASE_INSENSITIVE("i"), COMMENTS("x"), DOTALL("s"), MULTILINE("m"),
        UNICODE_CASE("u"), UNICODE_CHARACTER_CLASS("U"), UNIX_LINES("d");

        private final String flag;

        RegexFlag(String flag) {
            this.flag = flag;
        }

        public String getFlag() {
            return flag;
        }
    }

    public static final Regex ANY_CHAR = regex().anyChar();

    private final String pattern;

    private Pattern compiledPattern;

    private Regex(@NotNull String pattern) {
        this.pattern = pattern;
    }

    public Regex then() {
        return this;
    }

    public static void main(String[] args) {
        Regex matchUrl = rx().text("http").then().onceOrNot("s")
                .then().text("://")
                .then().zeroOrMore(rx().group(rx().onceOrMore(rx().charRange('a', 'z').charRange('A', 'Z')).dot()))
                .then().atLeast(2, ANY_CHAR).dot()
                .group(rx().anyOf("de", "com", "net", "org", "eu"));

        String url1 = "https://example.com";
        String url2 = "https://test.example.com";
        System.out.printf("REGEX: %s%n", matchUrl);
        System.out.printf("Matches %s: %s%n", url1, matchUrl.matches(url1));
        System.out.printf("Matches %s: %s%n", url2, matchUrl.matches(url2));
    }

    public static Regex rx() {
        return regex();
    }

    public static Regex regex() {
        return regex("");
    }

    public static Regex regex(@NotNull String pattern) {
        return new Regex(pattern);
    }

    public Regex alert() {
        return extendWith("\\a");
    }

    public Regex anyChar() {
        return extendWith(".");
    }

    public Regex anyOf(@NotNull CharSequence... patterns) {
        return anyOf(Arrays.asList(patterns));
    }

    public Regex anyOf(@NotNull Collection<CharSequence> patterns) {
        return extendWith(
                patterns.stream().reduce((p1, p2) -> p1 + "|" + p2).orElse(""));
    }

    public Regex atLeast(@PositiveOrZero int n, @NotNull CharSequence pattern) {
        return extendWith(pattern + "{" + n + ",}");
    }

    public Regex between(@PositiveOrZero int min, @PositiveOrZero int max,
            @NotNull CharSequence pattern) {
        return extendWith(pattern + "{" + min + "," + max + "}");
    }

    @Override
    public char charAt(int index) {
        return pattern.charAt(index);
    }

    public Regex charRange(char start, char end) {
        return checkExtendCharClass("[" + start + "-" + end + "]");
    }

    public Regex chars(@NotEmpty CharSequence chars) {
        return checkExtendCharClass("[" + chars + "]");
    }

    public Regex cr() {
        return extendWith("\\r");
    }

    public Regex digit() {
        return extendWith("\\d");
    }

    public Regex dot() {
        return extendWith("\\.");
    }

    public Regex endOfPreviousMatch() {
        return extendWith("\\G");
    }

    public Regex esc() {
        return extendWith("\\e");
    }

    public Regex exactly(@PositiveOrZero int n, @NotNull CharSequence pattern) {
        return extendWith(pattern + "{" + n + '}');
    }

    public Regex flags(@NotEmpty RegexFlag... flags) {
        return flags(Arrays.asList(flags));
    }

    public Regex flags(@NotEmpty Collection<RegexFlag> flags) {
        return extendWith("(?" + flags.stream()
                .map(RegexFlag::getFlag)
                .reduce("", (f1, f2) -> f1 + f2) + ')');
    }

    public Regex formFeed() {
        return extendWith("\\f");
    }

    public Regex group(@NotEmpty String name,
            @NotNull CharSequence groupPattern) {
        return extendWith("(?<" + name + '>' + groupPattern + ')');
    }

    public Regex group(@NotNull CharSequence groupPattern) {
        return extendWith("(" + groupPattern + ')');
    }

    public Regex groupAt(@PositiveOrZero int index) {
        return extendWith("\\" + index);
    }

    public Regex groupNamed(@NotEmpty String name) {
        return extendWith("\\k<" + name + '>');
    }

    public Regex groupNonCapturing(@NotNull CharSequence groupPattern) {
        return extendWith("(?:" + groupPattern + ')');
    }

    public Regex groupNonCapturingIndependent(
            @NotNull CharSequence groupPattern) {
        return extendWith("(?>" + groupPattern + ')');
    }

    public Regex horizontalWhitespace() {
        return extendWith("\\h");
    }

    public Regex inputEnd() {
        return extendWith("\\z");
    }

    public Regex inputEndWithoutTerminator() {
        return extendWith("\\Z");
    }

    public Regex inputStart() {
        return extendWith("\\A");
    }

    public Regex javaLower() {
        return extendWith("\\p{javaLowerCase}");
    }

    public Regex javaMirrored() {
        return extendWith("\\p{javaMirrored}");
    }

    public Regex javaUpper() {
        return extendWith("\\p{javaUpperCase}");
    }

    public Regex javaWhitespace() {
        return extendWith("\\p{javaWhitespace}");
    }

    public Regex lazy() {
        return reluctant();
    }

    @Override
    public int length() {
        return pattern.length();
    }

    public Regex lf() {
        return extendWith("\\n");
    }

    public Regex lineEnd() {
        return extendWith("$");
    }

    public Regex lineStart() {
        return extendWith("^");
    }

    public Regex lookAhead(@NotNull CharSequence groupPattern) {
        return extendWith("(?=" + groupPattern + ')');
    }

    public Regex lookAheadNegative(@NotNull CharSequence groupPattern) {
        return extendWith("(?!" + groupPattern + ')');
    }

    public Regex lookBehind(@NotNull CharSequence groupPattern) {
        return extendWith("(?<=" + groupPattern + ')');
    }

    public Regex lookBehindNegative(@NotNull CharSequence groupPattern) {
        return extendWith("(?<!" + groupPattern + ')');
    }

    public Regex noDigit() {
        return extendWith("\\D");
    }

    public Regex noHorizontalWhitespace() {
        return extendWith("\\H");
    }

    public Regex noVerticalWhitespace() {
        return extendWith("\\V");
    }

    public Regex noWhitespace() {
        return extendWith("\\S");
    }

    public Regex noWord() {
        return extendWith("\\W");
    }

    public Regex noWordBoundary() {
        return extendWith("\\B");
    }

    public Regex notCharRange(char start, char end) {
        return checkExtendCharClass("[^" + start + "-" + end + "]");
    }

    public Regex notChars(String chars) {
        return checkExtendCharClass("[^" + chars + "]");
    }

    public Regex notFlags(@NotEmpty RegexFlag... flags) {
        return notFlags(Arrays.asList(flags));
    }

    public Regex notFlags(@NotEmpty Collection<RegexFlag> flags) {
        return extendWith("(?-" + flags.stream()
                .map(RegexFlag::getFlag)
                .reduce("", (f1, f2) -> f1 + f2) + ')');
    }

    public Regex onceOrMore(@NotNull CharSequence pattern) {
        return extendWith(pattern + "+");
    }

    public Regex onceOrNot(@NotNull CharSequence pattern) {
        return extendWith(pattern + "?");
    }

    public Regex possessive() {
        return extendWith("+");
    }

    public Regex psxAlnum() {
        return extendWith("\\p{Alnum}");
    }

    public Regex psxAlpha() {
        return extendWith("\\p{Alpha}");
    }

    public Regex psxAscii() {
        return extendWith("\\p{ASCII}");
    }

    public Regex psxBlank() {
        return extendWith("\\p{Blank}");
    }

    public Regex psxCntrl() {
        return extendWith("\\p{Cntrl}");
    }

    public Regex psxGraph() {
        return extendWith("\\p{Graph}");
    }

    public Regex psxHexDigit() {
        return extendWith("\\p{XDigit}");
    }

    public Regex psxLower() {
        return extendWith("\\p{Lower}");
    }

    public Regex psxPrint() {
        return extendWith("\\p{Print}");
    }

    public Regex psxPunct() {
        return extendWith("\\p{Punct}");
    }

    public Regex psxSpace() {
        return extendWith("\\p{Space}");
    }

    public Regex psxUpper() {
        return extendWith("\\p{Upper}");
    }

    public Regex quote(@NotNull CharSequence pattern) {
        return extendWith(Pattern.quote(pattern.toString()));
    }

    public Regex reluctant() {
        return extendWith("?");
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return pattern.subSequence(start, end);
    }

    public boolean matches(String input) {
        if (compiledPattern == null) {
            compiledPattern = Pattern.compile(pattern);
        }
        return compiledPattern.matcher(input).matches();
    }

    public Regex tab() {
        return extendWith("\\t");
    }

    public Regex text(@NotNull CharSequence pattern) {
        return extendWith(pattern);
    }

    public String toString() {
        return pattern;
    }

    public Regex unicodeAlpha() {
        return extendWith("\\p{IsAlphabetic}");
    }

    public Regex unicodeCurrency() {
        return extendWith("\\p{Sc}");
    }

    public Regex unicodeExtendedGrapheme() {
        return extendWith("\\X");
    }

    public Regex unicodeGreek() {
        return extendWith("\\p{InGreek}");
    }

    public Regex unicodeLatin() {
        return extendWith("\\p{IsLatin}");
    }

    public Regex unicodeLinebreak() {
        return extendWith("\\R");
    }

    public Regex unicodeNotGreek() {
        return extendWith("\\P{InGreek}");
    }

    public Regex unicodeNotUpper() {
        return extendWith("[\\p{L}&&[^\\p{Lu}]]");
    }

    public Regex unicodeUpper() {
        return extendWith("\\p{Lu}");
    }

    public Regex verticalWhitespace() {
        return extendWith("\\v");
    }

    public Regex whitespace() {
        return extendWith("\\s");
    }

    public Regex word() {
        return extendWith("\\w");
    }

    public Regex wordBoundary() {
        return extendWith("\\b");
    }

    public Regex zeroOrMore(@NotNull CharSequence pattern) {
        return extendWith(pattern + "*");
    }

    private Regex checkExtendCharClass(@NotNull String charClass) {
        int lastChar = pattern.length() - 1;

        if (lastChar > 0 && pattern.charAt(lastChar) == ']') {
            return regex(pattern.substring(0, lastChar)).extendWith(
                    charClass.substring(1));
        } else {
            return extendWith(charClass);
        }
    }

    private Regex extendWith(@NotNull CharSequence add) {
        return new Regex(pattern + add);
    }
}
