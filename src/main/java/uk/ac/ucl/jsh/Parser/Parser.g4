grammar Parser;

compileUnit
    :   command NEWLINE
    ;

command
    :   pipe
    |   seq
    |   call
    ;

pipe
    :   call PIPE call
    |   pipe PIPE call
    ;

seq
    :   seq SEMI command
    |   command
    ;

call
    :   redirection* argument (redirection atom)*
    ;

atom
    :   redirection
    |   argument
    ;

argument
    :   quoted argument
    |   unquoted argument
    ;

redirection
    :   LT argument
    |   GT argument
    ;

quoted
    :   single_quoted
    |   double_quoted
    |   backquoted
    ;

single_quoted
    :   SQUOTE SQUOTE_CONTENT SQUOTE
    ;

double_quoted
    :   DQUOTE DQUOTE_CONTENT DQUOTE
    ;

backquoted
    :   BQUOTE BQUOTE_CONTENT BQUOTE
    ;


fragment WHITESPACE         : (' ' | '\t');
fragment SQUOTE_CONTENT     : [^\r\n\'];
fragment BQUOTE_CONTENT     : [^\r\n\`];
fragment DQUOTE_CONTENT     : (BQUOTE_CONTENT | [^\r\n\"\`])*;

SEMI        : ';';
PIPE        : '|';
DQUOTE      : '\"';
SQUOTE      : '\'';
BQUOTE      : '\`';
GT          : '>';
LT          : '<';
WHITESPACE  : [ \t] -> channel(HIDDEN);