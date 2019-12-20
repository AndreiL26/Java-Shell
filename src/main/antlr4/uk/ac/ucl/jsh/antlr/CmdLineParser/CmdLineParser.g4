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

fragment SQUOTED     : '\'' (~[\r\n'])+ '\'';
fragment BQUOTED     : '`' (~[\r\n`])+ '`';
fragment DQUOTED     : '"' (BQUOTED | ~[\r\n"`])+ '"';
fragment NON_KEYWORD : ~[\n'"`;|];
CALL_CONTENT         : (NON_KEYWORD | SQUOTED | BQUOTED | DQUOTED)+;

SEMI        : ';';
PIPE        : '|';
GT          : '>';
LT          : '<';
WHITESPACE  : [ \t] -> channel(HIDDEN);