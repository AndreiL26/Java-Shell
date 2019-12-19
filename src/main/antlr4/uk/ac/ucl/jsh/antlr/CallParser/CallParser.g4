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
cd      :   CD ' '+ argument;
ls      :   LS (' '+ argument)?;
cat     :   CAT (' '+ arguments)?;
echo    :   ECHO ' '+ arguments;
head    :   HEAD (' '+ arguments)?;
tail    :   TAIL (' '+ arguments)?;
grep    :   GREP (' '+ arguments);
sed     :   SED (' '+ arguments);
find    :   FIND (' '+ arguments);
wc      :   WC (' '+ arguments)?;

arguments
    :   argument
    |   argument ' '+ arguments
    ;

argument
    :   NON_KEYWORD+
    |   quoted
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
    :   (NON_KEYWORD | QUOTE_CONTENT | '"' | '`')*
    ;

double_quoted
    :   '"' content = dquote_content '"'
    ;

dquote_content 
    :   (NON_KEYWORD | QUOTE_CONTENT | '\'' | backquoted)*
    ;

backquoted
    :   '`' content = bquote_content '`'
    ;

bquote_content
    :   (NON_KEYWORD | QUOTE_CONTENT | '"' | '\'')*
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

NON_KEYWORD    : ~[ \t"'`\n\r;|><];
QUOTE_CONTENT  : [;|>< \t];