<?php

/* index.html */
class __TwigTemplate_60210e781c35b84183d8f8b904c773a48fdb4a50d8ac9b67e10ff8247e941927 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<!DOCTYPE html>
<html>
    <head>
        <title>My Webpage</title>
    </head>
    <body>
        <h1>My Webpage</h1>
        <p>Testando atributo 1 : ";
        // line 8
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["var"]) ? $context["var"] : null), 0, array(), "array"), "html", null, true);
        echo "</p>
        <p>Testando atributo 2 : ";
        // line 9
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["var"]) ? $context["var"] : null), 1, array(), "array"), "html", null, true);
        echo "</p>
        <p>Testando atributo 3 : ";
        // line 10
        echo twig_escape_filter($this->env, (isset($context["doo"]) ? $context["doo"] : null), "html", null, true);
        echo "</p>
        <ul>
        \t";
        // line 12
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["users"]) ? $context["users"] : null));
        foreach ($context['_seq'] as $context["_key"] => $context["user"]) {
            // line 13
            echo "        \t<li>";
            echo twig_escape_filter($this->env, $this->getAttribute($context["user"], "name", array()), "html", null, true);
            echo "</li>
        \t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['user'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 15
        echo "        </ul>
        ";
        // line 16
        $this->env->loadTemplate("include.html")->display($context);
        // line 17
        echo "    </body>
</html>";
    }

    public function getTemplateName()
    {
        return "index.html";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  59 => 17,  57 => 16,  54 => 15,  45 => 13,  41 => 12,  36 => 10,  32 => 9,  28 => 8,  19 => 1,);
    }
}
