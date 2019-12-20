grammar CmdLineParser;

compileUnit
    :   seq
    |   command
    ;

command
    :   pipe
    |   call
    ;

pipe
    :   call1=call PIPE call2=call   #pipeBase
    |   pipe PIPE call               #pipeRecursive
    ;

seq
    :   seq SEMI command                      #seqRecursive
    |   cmd1=command SEMI cmd2=command        #seqBase
    ;

call
    :   text = CALL_CONTENT
    ;

fragment SQUOTE_CONTENT     : (~[\r\n'])+;
fragment BQUOTE_CONTENT     : (~[\r\n`])+;
fragment DQUOTE_CONTENT     : (BQUOTE_CONTENT | ~[\r\n"`])+;
fragment NON_KEYWORD        : ~[\n'"`;|];
CALL_CONTENT                : (NON_KEYWORD | SQUOTE SQUOTE_CONTENT SQUOTE | BQUOTE BQUOTE_CONTENT BQUOTE | DQUOTE DQUOTE_CONTENT DQUOTE)+;

SEMI        : ';';
PIPE        : '|';
DQUOTE      : '"';
SQUOTE      : '\'';
BQUOTE      : '`';
GT          : '>';
LT          : '<';
UNQUOTED    : ~[ \t"'`\r\n;|<>];
WHITESPACE  : [ \t] -> channel(HIDDEN);