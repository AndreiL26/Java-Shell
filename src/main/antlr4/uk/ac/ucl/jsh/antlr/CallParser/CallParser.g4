grammar CallParser;

compileUnit
    :   pwd
    |   cd
    |   ls
    |   cat
    |   echo
    |   head
    |   tail
    |   grep
    |   sed
    |   find
    |   wc
    ;

pwd     :   PWD;
cd      :   CD WS+ argument;
ls      :   LS (WS+ argument)?;
cat     :   CAT (WS+ arguments)?;
echo    :   ECHO WS+ arguments;
head    :   HEAD (WS+ arguments)?;
tail    :   TAIL (WS+ arguments)?;
grep    :   GREP (WS+ arguments);
sed     :   SED (WS+ arguments);
find    :   FIND (WS+ arguments);
wc      :   WC (WS+ arguments)?;

arguments
    :   argument
    |   argument WS+ arguments
    ;

argument
    :   non_quote = non_keywords argument?
    |   quoted argument?
    ;

non_keywords
    :   NON_KEYWORD+
    ;

quoted
    :   single_quoted
    |   double_quoted
    |   backquoted
    ;

single_quoted
    :   '\'' content = squote_content '\''
    ;

squote_content
    :   (NON_KEYWORD | QUOTE_CONTENT | WS | '"' | '`')*
    ;

double_quoted
    :   '"' content = dquote_content '"'
    ;

dquote_content 
    :   (NON_KEYWORD | QUOTE_CONTENT | WS | '\'' | backquoted)*
    ;

backquoted
    :   '`' content = bquote_content '`'
    ;

bquote_content
    :   (NON_KEYWORD | QUOTE_CONTENT | WS | '"' | '\'')*
    ;

PWD     : 'pwd';
CD      : 'cd';
LS      : 'ls';
CAT     : 'cat';
ECHO    : 'echo';
HEAD    : 'head';
TAIL    : 'tail';
GREP    : 'grep';
SED     : 'sed';
FIND    : 'find';
WC      : 'wc';

WS             : [ \t];
NON_KEYWORD    : ~[ \t"'`\n\r;|><];
QUOTE_CONTENT  : [;|>< \t];