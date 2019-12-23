grammar CallParser;

compileUnit
    :   WS* arguments WS* EOF
    ;

arguments
    :   argument
    |   argument WS+ arguments
    ;

argument
    :   non_quote = non_quoted argument?
    |   quoted argument?
    ;

non_quoted
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
    :   content = (NON_KEYWORD | QUOTE_CONTENT | WS | '\'') dquote_content
    |   backquoted dquote_content
    |  
    ;

backquoted
    :   '`' content = bquote_content '`'
    ;

bquote_content
    :   (NON_KEYWORD | QUOTE_CONTENT | WS | '"' | '\'')*
    ;

WS             : [ \t];
NON_KEYWORD    : ~[ \t"'`\n\r;|><];
QUOTE_CONTENT  : [;|>< \t];